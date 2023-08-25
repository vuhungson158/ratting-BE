package kiis.ratingBE.enums;
//
//import org.hibernate.HibernateException;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.type.ConvertedBasicType;
//import org.hibernate.type.EnumType;
//import org.hibernate.type.descriptor.converter.spi.BasicValueConverter;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Types;
//
//public class PostgreSQLEnumType<T> implements ConvertedBasicType<T> {
//
//    @Override
//    public void nullSafeSet(PreparedStatement ps, Object obj, int index,
//                            SharedSessionContractImplementor session) throws HibernateException, SQLException {
//        if (obj == null) {
//            ps.setNull(index, Types.OTHER);
//        } else {
//            ps.setObject(index, obj.toString(), Types.OTHER);
//        }
//    }
//
//    @Override
//    public BasicValueConverter<T, ?> getValueConverter() {
//        return null;
//    }
//}
