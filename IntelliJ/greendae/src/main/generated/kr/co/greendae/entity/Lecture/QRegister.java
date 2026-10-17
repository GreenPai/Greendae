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

    public final QLecture lecture;

    public final StringPath regAttenScore = createString("regAttenScore");

    public final StringPath regEtcScore = createString("regEtcScore");

    public final StringPath regFinalScore = createString("regFinalScore");

    public final StringPath regGradeScore = createString("regGradeScore");

    public final StringPath regMidScore = createString("regMidScore");

    public final NumberPath<Integer> regNo = createNumber("regNo", Integer.class);

    public final StringPath regSemester = createString("regSemester");

    public final NumberPath<Integer> regTotalScore = createNumber("regTotalScore", Integer.class);

    public final StringPath regYear = createString("regYear");

    public final kr.co.greendae.entity.user.QStudent student;

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

