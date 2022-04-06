package com.nanos.fbclone.repository;

import com.nanos.fbclone.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity,String> {


}
