package com.itheima.mapper;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("SELECT * FROM user_role AS ur,role r WHERE ur.role_id=r.id AND ur.user_id=#{uid}")
    public List<Role> findByUid(int uid);

}
