package com.irisi.vidqr.vo;

import com.irisi.vidqr.entity.CollectionEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserVo {

    String id;
    String name;
    String email;
    String password;
    String username;
    CollectionEntity collectionEntity;
}
