package error;

import data.Block;

public class BlockInvalidError extends Error {

    private Block block;

    public BlockInvalidError(String message, Block block) {
        super(message);
        this.block = block;
    }

    public Block getBlock() {
        return this.block;
    }
}
