package data;

import java.util.ArrayList;

public class BlockChain {

    private ArrayList<Block> blockChain;

    public BlockChain() {
        this.blockChain = new ArrayList<>();
    }

    public boolean addBlock(Block block) {
        if (block.height == 0) {
            return this.blockChain.add(block);
        }
        if (block.isValid(this)) {
             return this.blockChain.add(block);
        } else {
            return false;
        }
    }

    public Block getTip() {
        return this.blockChain.get(this.blockChain.size() - 1);
    }

    public Block get(int index) {
        return this.blockChain.get(index);
    }

    public int calculateNextBlockTarget() {
        return 0;
    }
}
