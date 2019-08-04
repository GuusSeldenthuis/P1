import data.Block;
import data.BlockChain;
import miner.BlockMiner;

public class P1 {
    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();

        blockChain.addBlock(new Block(
                "0000004f89f478faa0e7b4a88c9927fca1d72353c7b90b2a890f911779d03440",
                "",
                0,
                0,
                186704,
                1564956562,
                "da7zvYXeHaaYz7yRylCnPgNXZJDTRcoeVBnZgajlFMmSpGBjNfckejzzZzphHDjTGGr5dd+GZbjstjSpa4aeQ4BVsgSa8CBvfrG2ZpHYRBtsK3FqLY53smWmEVu46WQ/pKsousVQC66XQLO+rAymHXcTvdusSCsD9WgsFpre1yzmnmzuvJSrihnuFRgbV8QWhUOIFDmjkTSQ8dcXzBeAysJC3vKcdJDGI1qdqm3qiC/Jfy5mbXQNK5Ic0FtYi7wnY/TQ4OpQzsXBkWkP8ycYB76Nq/m/bmwLj6RykNYSePiS9jY9ZAs6TaZwCGy7HYfkBiWPfP5YORa19RjioVI3HQ=="));

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
