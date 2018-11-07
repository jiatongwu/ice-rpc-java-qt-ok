[["java:package:com.my.demo"]]
module Demo
{
	 sequence<byte> WuBytes;
    interface TestService
    {
        WuBytes getData(WuBytes bytes,int len);
    };
};