package chess.domain.piece.mapper;

import chess.domain.piece.Piece;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class PieceMappers {

    private static final Collection<PieceMapper> pieceMappers = createMappers();

    private static Collection<PieceMapper> createMappers() {
        return Collections.unmodifiableCollection(
                Arrays.asList(
                        new PawnMapper(),
                        new KnightMapper(),
                        new BishopMapper(),
                        new RookMapper(),
                        new QueenMapper(),
                        new KingMapper()
                ));
    }

    public static String findNameBy(final Piece piece) {
        return pieceMappers.stream()
                .filter(mapper -> mapper.supports(piece))
                .map(mapper -> mapper.findNameBy(piece))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 기물에 해당하는 매퍼가 존재하지 않습니다."));
    }

    public static double findScoreBy(final Piece piece) {
        return pieceMappers.stream()
                .filter(mapper -> mapper.supports(piece))
                .map(PieceMapper::getScore)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 기물에 해당하는 매퍼가 존재하지 않습니다."));
    }

    private PieceMappers() {
    }
}
