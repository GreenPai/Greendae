package kr.co.greendae.entity.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -747215L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final StringPath addr1 = createString("addr1");

    public final StringPath addr2 = createString("addr2");

    public final StringPath email = createString("email");

    public final StringPath ename = createString("ename");

    public final StringPath gender = createString("gender");

    public final StringPath hp = createString("hp");

    public final DateTimePath<java.time.LocalDateTime> leaveDate = createDateTime("leaveDate", java.time.LocalDateTime.class);

    public final StringPath name = createString("name");

    public final StringPath nationality = createString("nationality");

    public final StringPath pass = createString("pass");

    public final QProfessor professor;

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final StringPath regip = createString("regip");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final StringPath ssn = createString("ssn");

    public final QStudent student;

    public final StringPath uid = createString("uid");

    public final StringPath zip = createString("zip");

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.professor = inits.isInitialized("professor") ? new QProfessor(forProperty("professor"), inits.get("professor")) : null;
        this.student = inits.isInitialized("student") ? new QStudent(forProperty("student"), inits.get("student")) : null;
    }

}

