package miner;

import data.Block;
import data.BlockChain;

public class BlockMiner {

    public static Block mine(BlockChain blockchain, String previouseBlock, int height) {
        Block block = new Block(
                previouseBlock,
                height,
                blockchain.calculateNextBlockTarget());

        do {
            block.timestamp = java.time.Instant.now().getEpochSecond();
            block.nonce++;
            block.hash = block.calculateBlockHash();
        } while (!block.isValid(blockchain));
        return block;
    }
}
