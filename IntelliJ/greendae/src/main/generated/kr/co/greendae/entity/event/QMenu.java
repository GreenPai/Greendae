package kr.co.greendae.entity.event;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMenu is a Querydsl query type for Menu
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMenu extends EntityPathBase<Menu> {

    private static final long serialVersionUID = 410532784L;

    public static final QMenu menu = new QMenu("menu");

    public final StringPath date = createString("date");

    public final StringPath menuRice = createString("menuRice");

    public final StringPath menuSoup = createString("menuSoup");

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath sub1 = createString("sub1");

    public final StringPath sub2 = createString("sub2");

    public final StringPath sub3 = createString("sub3");

    public final StringPath sub4 = createString("sub4");

    public final StringPath title = createString("title");

    public final StringPath week = createString("week");

    public QMenu(String variable) {
        super(Menu.class, forVariable(variable));
    }

    public QMenu(Path<? extends Menu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenu(PathMetadata metadata) {
        super(Menu.class, metadata);
    }

}

