package com.mt.springdata.entities;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.postgresql.util.PGobject;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class IPv4Type implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.OTHER};
    }

    @Override
    public Class<IPv4> returnedClass() {
        return null;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        return false;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        String ip = resultSet.getString(strings[0]);
        return (ip != null) ? new IPv4(ip) : null;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if (o == null) {
            preparedStatement.setNull(i, Types.OTHER);
        } else {
            PGobject holder = new PGobject();
            IPv4 iPv4 = (IPv4) o;
            holder.setType("inet");
            holder.setValue(iPv4.address());
            preparedStatement.setObject(i, holder);
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return null;
    }
}
