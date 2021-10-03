package com.example.teamfresh.voc.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVocReparationEntity is a Querydsl query type for VocReparationEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVocReparationEntity extends EntityPathBase<VocReparationEntity> {

    private static final long serialVersionUID = 1951118657L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVocReparationEntity vocReparationEntity = new QVocReparationEntity("vocReparationEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> deletedAt = createDateTime("deletedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> penaltyPrice = createNumber("penaltyPrice", Integer.class);

    public final StringPath reason = createString("reason");

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final QVocEntity voc;

    public QVocReparationEntity(String variable) {
        this(VocReparationEntity.class, forVariable(variable), INITS);
    }

    public QVocReparationEntity(Path<? extends VocReparationEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVocReparationEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVocReparationEntity(PathMetadata metadata, PathInits inits) {
        this(VocReparationEntity.class, metadata, inits);
    }

    public QVocReparationEntity(Class<? extends VocReparationEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.voc = inits.isInitialized("voc") ? new QVocEntity(forProperty("voc")) : null;
    }

}

