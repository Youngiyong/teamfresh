package com.example.teamfresh.voc.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVocPenaltyEntity is a Querydsl query type for VocPenaltyEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVocPenaltyEntity extends EntityPathBase<VocPenaltyEntity> {

    private static final long serialVersionUID = -2032105259L;

    public static final QVocPenaltyEntity vocPenaltyEntity = new QVocPenaltyEntity("vocPenaltyEntity");

    public final StringPath answer = createString("answer");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> isSign = createNumber("isSign", Integer.class);

    public final NumberPath<Integer> isVerify = createNumber("isVerify", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> vocId = createNumber("vocId", Long.class);

    public QVocPenaltyEntity(String variable) {
        super(VocPenaltyEntity.class, forVariable(variable));
    }

    public QVocPenaltyEntity(Path<? extends VocPenaltyEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVocPenaltyEntity(PathMetadata metadata) {
        super(VocPenaltyEntity.class, metadata);
    }

}

