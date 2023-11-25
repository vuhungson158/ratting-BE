package kiis.ratingBE.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kiis.ratingBE.common.BaseResponse;
import org.apache.tomcat.util.json.JSONParser;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = "kiis.ratingBE.features")
public class ResponseWrapper implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(@NotNull MethodParameter returnType,
                            @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  @NotNull MethodParameter returnType,
                                  @NotNull MediaType selectedContentType,
                                  @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  @NotNull ServerHttpRequest request,
                                  @NotNull ServerHttpResponse response) {
        if (body instanceof String) {
            final ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(body);
            } catch (final JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return new BaseResponse<>(body);
    }
}
