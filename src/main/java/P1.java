import data.Block;
import data.BlockChain;
import miner.BlockMiner;

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

        System.out.println("Starting mining 4 new blocks...");
        while (blockChain.getSize() != 5) {
            blockChain.addBlock(BlockMiner.mine(blockChain, blockChain.getTip().hash, blockChain.getSize()));
            System.out.println("Block " + blockChain.getTip().height + " mined!");
        }

        if (!blockChain.verify()) {
            System.out.println("Invalid blockchain!");
        } else {
            System.out.println("Valid blockchain!");
        }

        blockChain.printOut();

    }
}
