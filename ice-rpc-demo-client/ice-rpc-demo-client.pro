HEADERS += \
    demo.h

SOURCES += \
    demo.cpp \
    ice_client.cpp



LIBS += -L/usr/lib64/c++11 -lIce -lIceUtil


INCLUDEPATH += /usr/include/IceUtil
INCLUDEPATH += /usr/include/Ice
