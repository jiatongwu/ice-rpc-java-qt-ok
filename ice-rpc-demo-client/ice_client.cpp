#include <Ice/Ice.h>
#include "demo.h"
#include <QFile>
#include <QDebug>
#include <QDataStream>

using namespace std;
using namespace Demo;

int
main(int argc, char* argv[])
{
    int status = 0;
    Ice::CommunicatorPtr ic;
    try {
        ic = Ice::initialize(argc, argv);


        Ice::ObjectPrx base = ic->stringToProxy("TestService:default -h 192.168.12.26 -p 10000");
        TestServicePrx printer =TestServicePrx::checkedCast(base);
        if (!printer)
        {
            throw "Invalid proxy";
        }
        std::string s = "whatever";
        ::Demo::WuBytes wuBytes(s.begin(),s.end());
       ::Demo::WuBytes result=printer->getData(wuBytes,100);
        //std::string string2(result.begin(),result.end());
       // ::std::cout<<string2<<::std::endl;
        QByteArray* qByteArray=        new QByteArray(reinterpret_cast<const char*>(result.data()), result.size());


        QFile file("/home/wu/out.zip");
        if(!file.open(QIODevice::WriteOnly))
        { qDebug() << "Can't open file for writing"; return 0; }
        QDataStream out(&file);
        out.setVersion(QDataStream::Qt_5_9);
    //        out << int(12) << QByteArray("123"); file.close();
        out<<*qByteArray;
        file.close();





    } catch (const Ice::Exception&ex) {
        cerr << ex << endl;
        status = 1;
    } catch (const char* msg) {
        cerr << msg << endl;
        status = 1;
    }
    if (ic)
        ic->destroy();
    return status;
}
