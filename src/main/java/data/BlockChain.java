package data;

import error.BlockInvalidError;

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
        try {
            block.validate(this);
             return this.blockChain.add(block);
        } catch (BlockInvalidError blockInvalidError) {
            System.out.println("Unable to add block to current blockChain: " + blockInvalidError.getMessage());
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

    public boolean verify() {
        for (Block block : this.blockChain) {
            try {
                block.validate(this);
            } catch (BlockInvalidError blockInvalidError) {
                System.out.println("Verifying failed at block: " + blockInvalidError.getBlock().height);
                System.out.println("Reason: " + blockInvalidError.getMessage());
                return false;
            }
        }
        return true;
    }

    public void printOut() {
        for (Block block : this.blockChain) {
            System.out.println(block.toString());
        }
    }

    public int getSize() {
        return this.blockChain.size();
    }
}
