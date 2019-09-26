package com.example.lambdas.usage;


import java.util.function.Supplier;

/**
 * 描述:
 * lambda表达式用法
 *
 * @author zed
 * @since 2019-09-26 10:35
 */
public class LambdaUsage {
    /**
     * logger
     */
    private static class Logger{
        private boolean debug = true;
        private boolean isDebugEnabled(){
            return debug;
        }
        private void debug(String message){
            if (isDebugEnabled()){
                System.out.println(message);
            }
        }
        /**
         * lambda表达式实现
         * @param message msg
         */
        private void debug(Supplier<String> message){
            if (isDebugEnabled()){
                debug(message.get());
            }
        }
        private String expensiveOperation(){
            return "WoW~";
        }

        /**
         * 传统方式
         */
        private void log(){
            Logger log = new Logger();
            if (log.isDebugEnabled()){
                log.debug("Look at this: " + expensiveOperation());
            }
        }

        /**
         * lambda表达式方式
         */
        private void logWithLambda() {
            Logger log = new Logger();
            log.debug(() -> "Look at this: " + expensiveOperation());
        }

        public static void main(String[] args) {
            Logger log = new Logger();
            log.logWithLambda();
            log.log();
        }
    }

}
