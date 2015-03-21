基于现有的日志打印框架，封装了一套新的日志打印组件，要求所有获取日志Logger的地方，采用新的方案，样例如下
private static final ILog   StaticLog = LogFactory.getLog(LogRequestFilter.class);
它主要提供了一个对常用日志组件的封装，以实现常见切面的需求，如应用错误日志的统一搜集，日志的串联等功能
