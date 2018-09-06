import component.ClientThread;
import config.ZookeeperClient;
import org.apache.zookeeper.ZooKeeper;

import java.lang.management.ManagementFactory;

/**
 * Created by zhuocongbin
 * date 2018/8/30
 */
public class ClientMain {
    public static void main(String[] args) throws InterruptedException {
        ZooKeeper zookeeper = ZookeeperClient.getZookeeper();
        String name = ManagementFactory.getRuntimeMXBean().getName();
        int index = name.indexOf("@");
        String pid = name.substring(0, index);
        Thread thread = new Thread(new ClientThread(pid, zookeeper));
        thread.start();
    }
}
