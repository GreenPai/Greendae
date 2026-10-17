package kr.co.greendae.entity.community.comment;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBasicComment is a Querydsl query type for BasicComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBasicComment extends EntityPathBase<BasicComment> {

    private static final long serialVersionUID = -697067166L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBasicComment basicComment = new QBasicComment("basicComment");

    public final NumberPath<Integer> cno = createNumber("cno", Integer.class);

    public final StringPath content = createString("content");

    public final NumberPath<Integer> parent = createNumber("parent", Integer.class);

    public final StringPath regip = createString("regip");

    public final kr.co.greendae.entity.user.QUser user;

    public final DateTimePath<java.time.LocalDateTime> wdate = createDateTime("wdate", java.time.LocalDateTime.class);

    public QBasicComment(String variable) {
        this(BasicComment.class, forVariable(variable), INITS);
    }

    public QBasicComment(Path<? extends BasicComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBasicComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBasicComment(PathMetadata metadata, PathInits inits) {
        this(BasicComment.class, metadata, inits);
    }

    public QBasicComment(Class<? extends BasicComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new kr.co.greendae.entity.user.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

