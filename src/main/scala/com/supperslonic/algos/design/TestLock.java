package com.supperslonic.algos.design;

import java.util.Optional;
import java.util.UUID;

public class TestLock {
    public class TestLeaderLock {
        private TestLeaderElection leaderElection;

        public TestLeaderLock(TestLeaderElection leaderElection) {
            this.leaderElection = leaderElection;
        }

        /**
         * Increment usage count of the lock
         */
        public void inc() {
            //TODO
            throw new RuntimeException("not implemented");
        }

        /**
         * Usage count should be decreased.
         * If usage count becomes zero, lock should be released.
         *
         * @return updated usage count
         */
        public int release() {
            //TODO
            throw new RuntimeException("not implemented");
        }
    }

    public class TestLeaderElection {

        private StorageSystem storageSystem;
        private String leaderName;

        public TestLeaderElection(StorageSystem storageSystem) {
            this.storageSystem = storageSystem;
            this.leaderName = UUID.randomUUID().toString();
        }

        /**
         * Acquires a lock for the given name and returns the lock instance.
         * If was not able to obtain a lock - no lock is being returned.
         * <p>
         * This function can be called multiple times for the same lockName.
         * If lock was already obtained, it should just increment the usage count and return the same lock instance.
         *
         * @param lockName
         * @return
         */
        public Optional<TestLeaderLock> acquireLeadership(String lockName) {
            //TODO
            throw new RuntimeException("not implemented");
        }

        /**
         * Removes the lock entirely
         */
        public void deleteLock(String lockName) {
            //TODO
            throw new RuntimeException("not implemented");
        }
    }

    /**
     * Physical storage system
     */
    public interface StorageSystem {
        /**
         * Obtains a lock for a given leader
         *
         * @param lockName
         * @param leaderName
         * @return true if was able to get the lock, otherwise false
         */
        boolean getLock(String lockName, String leaderName);

        /**
         * Updates the lock state for the given leader (heart-beat)
         *
         * @param lockName
         * @param leaderName
         */
        void updateLock(String lockName, String leaderName);

        /**
         * Removes the lock for a given leader
         */
        void deleteLock(String lockName, String leaderName);
    }

    public class Usage {
        private TestLeaderElection leaderElection;

        public Usage(TestLeaderElection leaderElection) {
            this.leaderElection = leaderElection;
        }

        /**
         * Can be called multiple times in different threads
         */
        public void doWork() {
            Optional<TestLeaderLock> lockOpt = leaderElection.acquireLeadership("lock1");
            if (lockOpt.isPresent()) {
                try {
                    //Do some important work here
                } finally {
                    lockOpt.get().release();
                }
            }
        }
    }
}
