/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobitrans.openbidder.workers;

import com.google.openbidder.bidding.*;
import mobitrans.openbidder.cache.CreativesCache;
import mobitrans.openbidder.cache.RulesCache;
import mobitrans.openbidder.data.bidding.Creative;
import mobitrans.openbidder.data.bidding.Rule;
import mobitrans.openbidder.dataAccessLayer.DataAccess;
import mobitrans.openbidder.db.DatabaseManager;
import java.util.List;
import org.slf4j.*;

/**
 *
 * @author tkhalilov
 */
public class CreativesWorker implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(CreativesWorker.class);
    private DataAccess DataAccessManager;
    private Thread Current;

    public CreativesWorker() {
        DataAccessManager = new DataAccess();
    }
    
     public void start() {
        if (Current == null) {
            Current = new Thread(this);
            Current.start();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {

                // 1. Fetching all the rules from the Database
                List<Creative> Creatives = DataAccessManager.GetCreatives();

                // 2. Updating the cache with the new rules fetched (while locking access to the object)
                synchronized (CreativesCache.Cache) {
                    CreativesCache.Cache.clear();
                    CreativesCache.Cache.addAll(Creatives);
                }

                Thread.sleep(60000);
            }
        } catch (Exception Ex) {
            logger.error(Ex.getMessage());
            logger.error("Thread has interrupted and terminated.");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            logger.error("Thread has been finalized.");
        } catch (Throwable t) {
            throw t;
        } finally {
            super.finalize();
        }
    }
}
