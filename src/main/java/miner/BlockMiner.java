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
            if (block.timestamp != java.time.Instant.now().getEpochSecond()) {
                block.timestamp = java.time.Instant.now().getEpochSecond();
                System.out.println("Mining with " + Double.valueOf(block.nonce / 1000) + " KH/s.");
                block.nonce = 0;
            } else {
                block.nonce++;
            }

            block.hash = block.calculateBlockHash();

        } while (new BigInteger(block.hash, 16).compareTo(new BigInteger("00000fffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", 16)) > 0);
        return block;
    }
}
