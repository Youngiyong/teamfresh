package com.example.teamfresh.voc.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVocEntity is a Querydsl query type for VocEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVocEntity extends EntityPathBase<VocEntity> {

    private static final long serialVersionUID = -1961131782L;

    public static final QVocEntity vocEntity = new QVocEntity("vocEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> deletedAt = createDateTime("deletedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> deliveryId = createNumber("deliveryId", Long.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> isClaim = createNumber("isClaim", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath status = createString("status");

    public final StringPath type = createString("type");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final ListPath<VocPenaltyEntity, QVocPenaltyEntity> vocClam = this.<VocPenaltyEntity, QVocPenaltyEntity>createList("vocClam", VocPenaltyEntity.class, QVocPenaltyEntity.class, PathInits.DIRECT2);

    public final ListPath<VocReparationEntity, QVocReparationEntity> vocReparation = this.<VocReparationEntity, QVocReparationEntity>createList("vocReparation", VocReparationEntity.class, QVocReparationEntity.class, PathInits.DIRECT2);

    public QVocEntity(String variable) {
        super(VocEntity.class, forVariable(variable));
    }

    public QVocEntity(Path<? extends VocEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVocEntity(PathMetadata metadata) {
        super(VocEntity.class, metadata);
    }

}

