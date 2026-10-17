package kr.co.greendae.entity.event;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGallery is a Querydsl query type for Gallery
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGallery extends EntityPathBase<Gallery> {

    private static final long serialVersionUID = 1263690593L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGallery gallery = new QGallery("gallery");

    public final StringPath comment = createString("comment");

    public final StringPath content = createString("content");

    public final NumberPath<Integer> hit = createNumber("hit", Integer.class);

    public final StringPath imageoName = createString("imageoName");

    public final StringPath imagesName = createString("imagesName");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath regip = createString("regip");

    public final StringPath title = createString("title");

    public final kr.co.greendae.entity.user.QUser user;

    public final DateTimePath<java.time.LocalDateTime> wdate = createDateTime("wdate", java.time.LocalDateTime.class);

    public QGallery(String variable) {
        this(Gallery.class, forVariable(variable), INITS);
    }

    public QGallery(Path<? extends Gallery> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGallery(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGallery(PathMetadata metadata, PathInits inits) {
        this(Gallery.class, metadata, inits);
    }

    public QGallery(Class<? extends Gallery> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new kr.co.greendae.entity.user.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

