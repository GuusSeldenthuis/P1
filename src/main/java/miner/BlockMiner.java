package miner;

import data.Block;
import data.BlockChain;
import error.BlockInvalidError;

import java.math.BigInteger;

public class BlockMiner {

    public static Block mine(BlockChain blockchain, String previousBlock, int height) {
        Block block = new Block(
                previousBlock,
                height,
                blockchain.calculateNextBlockTarget());

        block.timestamp = java.time.Instant.now().getEpochSecond();

        do {
            block.nonce++;
            block.hash = block.calculateBlockHash();

            if (block.timestamp != java.time.Instant.now().getEpochSecond()) {
                block.timestamp = java.time.Instant.now().getEpochSecond();
                System.out.println("Reset nonce to 0 after " + block.nonce + " iterations and updated timestamp to " + block.timestamp);
                block.nonce = 0;
            }

        } while (new BigInteger(block.hash, 16).compareTo(new BigInteger("00000fffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", 16)) > 0);
        return block;
    }
}
