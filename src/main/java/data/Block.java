package data;

import crypto.Sha256;

import java.math.BigInteger;

public class Block {
    public String hash;
    public String previousBlock;
    public int height;
    public int difficulty;
    public long nonce;
    public long timestamp;

    public Block(String hash,
                 String previousBlock,
                 int height,
                 int target,
                 long nonce,
                 long timestamp) {
        this.hash = hash;
        this.previousBlock = previousBlock;
        this.height = height;
        this.difficulty = target;
        this.nonce = nonce;
        this.timestamp = timestamp;
    }

    public Block (String previousBlock,
                  int height,
                  int target
    ) {
        this.previousBlock = previousBlock;
        this.height = height;
        this.difficulty = target;
    }

    public String calculateBlockHash() {
        return Sha256.encrypt(this.previousBlock +
        this.height +
        this.nonce +
        this.timestamp);
    }

    public boolean isValid(BlockChain blockChain) {
        return
                calculateBlockHash().equals(this.hash) &&
                this.previousBlock == blockChain.get(this.height - 1).hash &&
                new BigInteger(this.hash, 16).compareTo(new BigInteger("0000ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", 16)) < 0;
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
                '}';
    }
}
