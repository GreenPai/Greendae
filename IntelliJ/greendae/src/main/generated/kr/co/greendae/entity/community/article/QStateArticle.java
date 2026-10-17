package kr.co.greendae.entity.community.article;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStateArticle is a Querydsl query type for StateArticle
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStateArticle extends EntityPathBase<StateArticle> {

    private static final long serialVersionUID = 128758015L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStateArticle stateArticle = new QStateArticle("stateArticle");

    public final StringPath cate = createString("cate");

    public final StringPath content = createString("content");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath pass = createString("pass");

    public final StringPath regip = createString("regip");

    public final QResStateArticle resStateArticle;

    public final StringPath state = createString("state");

    public final StringPath title = createString("title");

    public final kr.co.greendae.entity.user.QUser user;

    public final DateTimePath<java.time.LocalDateTime> wdate = createDateTime("wdate", java.time.LocalDateTime.class);

    public QStateArticle(String variable) {
        this(StateArticle.class, forVariable(variable), INITS);
    }

    public QStateArticle(Path<? extends StateArticle> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStateArticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStateArticle(PathMetadata metadata, PathInits inits) {
        this(StateArticle.class, metadata, inits);
    }

    public QStateArticle(Class<? extends StateArticle> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.resStateArticle = inits.isInitialized("resStateArticle") ? new QResStateArticle(forProperty("resStateArticle"), inits.get("resStateArticle")) : null;
        this.user = inits.isInitialized("user") ? new kr.co.greendae.entity.user.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

