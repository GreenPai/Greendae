package kr.co.greendae.entity.Lecture;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRegister is a Querydsl query type for Register
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRegister extends EntityPathBase<Register> {

    private static final long serialVersionUID = -867521808L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRegister register = new QRegister("register");

    public final kr.co.greendae.entity.basic.QBaseEntity _super = new kr.co.greendae.entity.basic.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final QLecture lecture;

    public final NumberPath<java.math.BigDecimal> regAttenScore = createNumber("regAttenScore", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> regEtcScore = createNumber("regEtcScore", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> regFinalScore = createNumber("regFinalScore", java.math.BigDecimal.class);

    public final EnumPath<Grade> regGradeScore = createEnum("regGradeScore", Grade.class);

    public final NumberPath<java.math.BigDecimal> regMidScore = createNumber("regMidScore", java.math.BigDecimal.class);

    public final NumberPath<Long> regNo = createNumber("regNo", Long.class);

    public final NumberPath<Integer> regSemester = createNumber("regSemester", Integer.class);

    public final NumberPath<java.math.BigDecimal> regTotalScore = createNumber("regTotalScore", java.math.BigDecimal.class);

    public final NumberPath<Integer> regYear = createNumber("regYear", Integer.class);

    public final EnumPath<RegisterStatus> status = createEnum("status", RegisterStatus.class);

    public final kr.co.greendae.entity.user.QStudent student;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRegister(String variable) {
        this(Register.class, forVariable(variable), INITS);
    }

    public QRegister(Path<? extends Register> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRegister(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRegister(PathMetadata metadata, PathInits inits) {
        this(Register.class, metadata, inits);
    }

    public QRegister(Class<? extends Register> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new QLecture(forProperty("lecture"), inits.get("lecture")) : null;
        this.student = inits.isInitialized("student") ? new kr.co.greendae.entity.user.QStudent(forProperty("student"), inits.get("student")) : null;
    }

}

