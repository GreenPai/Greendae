package kr.co.greendae.entity.Lecture;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLecture is a Querydsl query type for Lecture
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLecture extends EntityPathBase<Lecture> {

    private static final long serialVersionUID = -922856559L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLecture lecture = new QLecture("lecture");

    public final StringPath book = createString("book");

    public final StringPath lecCate = createString("lecCate");

    public final StringPath lecClass = createString("lecClass");

    public final StringPath lecContent = createString("lecContent");

    public final NumberPath<Integer> lecCredit = createNumber("lecCredit", Integer.class);

    public final StringPath lecEvaluation = createString("lecEvaluation");

    public final NumberPath<Integer> lecGrade = createNumber("lecGrade", Integer.class);

    public final NumberPath<Integer> lecLevel = createNumber("lecLevel", Integer.class);

    public final StringPath lecMajor = createString("lecMajor");

    public final StringPath lecName = createString("lecName");

    public final StringPath lecNo = createString("lecNo");

    public final StringPath lecRoom = createString("lecRoom");

    public final StringPath lecScheduleEnd = createString("lecScheduleEnd");

    public final StringPath lecScheduleStart = createString("lecScheduleStart");

    public final NumberPath<Integer> lecStdCount = createNumber("lecStdCount", Integer.class);

    public final NumberPath<Integer> lecStdTotal = createNumber("lecStdTotal", Integer.class);

    public final StringPath lecTimeEnd = createString("lecTimeEnd");

    public final StringPath lecTimeStart = createString("lecTimeStart");

    public final StringPath lecWeekday = createString("lecWeekday");

    public final kr.co.greendae.entity.user.QProfessor professor;

    public QLecture(String variable) {
        this(Lecture.class, forVariable(variable), INITS);
    }

    public QLecture(Path<? extends Lecture> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLecture(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLecture(PathMetadata metadata, PathInits inits) {
        this(Lecture.class, metadata, inits);
    }

    public QLecture(Class<? extends Lecture> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.professor = inits.isInitialized("professor") ? new kr.co.greendae.entity.user.QProfessor(forProperty("professor"), inits.get("professor")) : null;
    }

}

