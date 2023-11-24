package kiis.ratingBE.common.comment;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public abstract class CommentService {
    // TODO
    public boolean like(@PathVariable long id) {
        return true;
    }

    // TODO
    public boolean dislike(@PathVariable long id) {
        return true;
    }
}
