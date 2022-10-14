package com.mt.springdata.repositories;

import com.mt.springdata.entities.UserStatusInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusInfoRepository extends JpaRepository<UserStatusInfo,Long> {
}
