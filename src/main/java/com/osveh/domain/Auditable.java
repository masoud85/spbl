package com.osveh.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.awt.event.AWTEventListener;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AWTEventListener.class)
@NoArgsConstructor
@Data
public abstract class Auditable {

    @CreatedBy
    private String createdBy;
    @CreatedDate
    private LocalDateTime creationDate;
    @LastModifiedBy
    private String lastModifiedBy;
    @LastModifiedDate
    private LocalDateTime lastModifiedData;

}
