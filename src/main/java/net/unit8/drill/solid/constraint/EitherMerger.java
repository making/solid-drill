package net.unit8.drill.solid.constraint;

import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.fn.Either;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

public class EitherMerger {
    public static <T1, T2> Either<ConstraintViolations, Tuple2<T1, T2>> merge(Either<ConstraintViolations, T1> e1, Either<ConstraintViolations, T2> e2) {
        ConstraintViolations violations = new ConstraintViolations();
        T1 t1 = e1.fold(v -> {
            violations.addAll(v);
            return null;
        }, e -> e);
        T2 t2 = e2.fold(v -> {
            violations.addAll(v);
            return null;
        }, e -> e);
        if (violations.isEmpty()) {
            return Either.right(Tuples.of(t1, t2));
        } else {
            return Either.left(violations);
        }
    }
}
