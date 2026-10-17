package kr.co.greendae.entity.community.article;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResStateArticle is a Querydsl query type for ResStateArticle
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResStateArticle extends EntityPathBase<ResStateArticle> {

    private static final long serialVersionUID = 1975417803L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResStateArticle resStateArticle = new QResStateArticle("resStateArticle");

    public final StringPath content = createString("content");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath regip = createString("regip");

    public final QStateArticle stateArticle;

    public final StringPath title = createString("title");

    public final kr.co.greendae.entity.user.QUser user;

    public final DateTimePath<java.time.LocalDateTime> wdate = createDateTime("wdate", java.time.LocalDateTime.class);

    public QResStateArticle(String variable) {
        this(ResStateArticle.class, forVariable(variable), INITS);
    }

    public QResStateArticle(Path<? extends ResStateArticle> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResStateArticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResStateArticle(PathMetadata metadata, PathInits inits) {
        this(ResStateArticle.class, metadata, inits);
    }

    public QResStateArticle(Class<? extends ResStateArticle> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.stateArticle = inits.isInitialized("stateArticle") ? new QStateArticle(forProperty("stateArticle"), inits.get("stateArticle")) : null;
        this.user = inits.isInitialized("user") ? new kr.co.greendae.entity.user.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

