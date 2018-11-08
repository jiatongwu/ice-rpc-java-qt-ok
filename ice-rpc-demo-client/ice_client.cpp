#include <Ice/Ice.h>
#include "demo.h"
#include <QFile>
#include <QDebug>
#include <QDataStream>
#include <QByteArray>

using namespace std;
using namespace Demo;

int
main(int argc, char* argv[])
{
    int status = 0;
    Ice::CommunicatorPtr ic;
    try {

        // Get the initialized property set.

      // Ice::PropertiesPtr props = Ice::createProperties(argc, argv);
        // Make sure that network and protocol tracing are off.
        //
      // props->setProperty("Ice.MessageSizeMax", "102400000");
       // props->setProperty("Ice.Trace.Protocol", "0");
        // Initialize a communicator with these properties.
        //
       // Ice::CommunicatorPtr ic = Ice::initialize(argc, argv);
     ic = Ice::initialize(argc, argv);
      // Ice::InitializationData data;





        Ice::ObjectPrx base = ic->stringToProxy("TestService:default -h 192.168.1.185 -p 10000");
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


        QFile file("/root/out.zip");
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
