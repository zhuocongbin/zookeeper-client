package component;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhuocongbin
 * date 2018/8/30
 */
public class ClientThread implements Runnable {
    private String pid;
    private ZooKeeper zk;

    public ClientThread(String pid, ZooKeeper zk) {
        this.pid = pid;
        this.zk = zk;
    }

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
            zk.create("/ztest/" + pid, pid.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            while (true){

            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
