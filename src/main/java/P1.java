import data.Block;
import data.BlockChain;
import miner.BlockMiner;

import java.math.BigInteger;

public class P1 {
    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();

        blockChain.addBlock(new Block(
                "000000f7375e0c1d6d782e03cd2c10a5e62708fe415732c951aca5b7e704fa86",
                "",
                0,
                0,
                23182942,
                1564871394));

        System.out.println("Starting mining block 1...");
        Block block1 = BlockMiner.mine(blockChain, "000000f7375e0c1d6d782e03cd2c10a5e62708fe415732c951aca5b7e704fa86", 1);


        System.out.println("Mined first block! " + block1.toString());
    }
}
