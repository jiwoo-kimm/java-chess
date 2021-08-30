package chess.domain.command;

import chess.domain.player.Position;

import java.util.List;

public class MoveParameters {

    private static final int SOURCE_INDEX = 0;
    private static final int TARGET_INDEX = 1;

    private final Position source;
    private final Position target;

    public MoveParameters(final List<String> parameters) {
        this(Position.of(parameters.get(SOURCE_INDEX)), Position.of(parameters.get(TARGET_INDEX)));
    }

    public MoveParameters(String source, String target) {
        this(Position.of(source), Position.of(target));
    }

    public MoveParameters(final Position source, final Position target) {
        this.source = source;
        this.target = target;
    }

    public Position getSource() {
        return source;
    }

    public Position getTarget() {
        return target;
    }
}
