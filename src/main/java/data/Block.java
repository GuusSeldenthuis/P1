package data;

import crypto.Sha256;
import error.BlockInvalidError;

import java.math.BigInteger;

public class Block {
    public String hash;
    public String previousBlock;
    public int height;
    public int difficulty;
    public long nonce;
    public long timestamp;
    public String data;

    public Block(String hash,
                 String previousBlock,
                 int height,
                 int target,
                 long nonce,
                 long timestamp,
                 String data) {
        this.hash = hash;
        this.previousBlock = previousBlock;
        this.height = height;
        this.difficulty = target;
        this.nonce = nonce;
        this.timestamp = timestamp;
        this.data = data;
    }

    public Block (String previousBlock,
                  int height,
                  int target,
                  String data
    ) {
        this.previousBlock = previousBlock;
        this.height = height;
        this.difficulty = target;
        this.data = data;
    }

    public String calculateBlockHash() {
        return Sha256.encryptSha256(
        this.previousBlock +
        this.height +
        this.nonce +
        this.timestamp +
        this.data);
    }

    public void validate(BlockChain blockChain) throws BlockInvalidError {

        // Check the block's hash.
        if (!calculateBlockHash().equals(this.hash)) {
            throw new BlockInvalidError("Hash doesn't match self-generated hash.", this);
        }

        // Check previous block.
        if (this.height != 0 && this.previousBlock != blockChain.get(this.height - 1).hash) {
            throw new BlockInvalidError("Previous block doesn't match the chain's previous height.", this);
        }

        // Check block-hash's difficulty compared to the current target.
        if (new BigInteger(this.hash, 16).compareTo(new BigInteger("00000fffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", 16)) >= 0) {
            throw new BlockInvalidError("Block difficulty is underneath current target.", this);
        }

    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousBlock='" + previousBlock + '\'' +
                ", height=" + height +
                ", target=" + difficulty +
                ", nonce=" + nonce +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
}
