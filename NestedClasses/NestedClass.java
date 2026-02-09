package NestedClasses;

public class NestedClass {
    public static void main(String[] args) {
        MonitoringSystem generalModule = new MonitoringSystem() {
            @Override
            public void StartMonitoring() {
                System.out.println("Мониторинг общих показателей стартовал");
            }
        };
        MonitoringSystem errorModule = new MonitoringSystem() {
            @Override
            public void StartMonitoring() {
                System.out.println("Мониторинг отслеживания ошибок стартовал");
            }
        };
        generalModule.StartMonitoring();
        errorModule.StartMonitoring();
    }

    public interface MonitoringSystem {
        public void StartMonitoring();
    }
}

