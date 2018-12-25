package com.mingqian.core;

import com.mingqian.core.exception.AppException;
import org.apache.commons.io.IOUtils;

import java.io.*;


/**
 * 对象的一些常用方法。
 */
public class Objects {
    /**
     * 判断两个对象是否相等。
     * @param a1 Object
     * @param a2 Object
     * @return true 两个对象相等。
     */
    public static boolean equals(Object a1, Object a2) {
        return a1 != null ? a1.equals(a2) : a2 == null;
    }

    /**
     * get the bytes size of an object.
     * @param obj
     * @return
     */
    public static int sizeOf(Object obj) {
        return obj == null ? 0 : objectToBytes(obj).length;
    }

    /**
     * 转换对象到输入流。
     * @param object
     * @return
     */
    public static InputStream objectToStream(Object object) {
        return new ByteArrayInputStream(objectToBytes(object));
    }

    /**
     * 转换对象到字节数组。
     * @param object
     * @return
     */
    public static byte[] objectToBytes(Object object) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            objectToStream(object, baos);
            return baos.toByteArray();
        } finally {
            IOUtils.closeQuietly(baos);
        }
    }

    /**
     * 对象转化为输出流。
     * @param object
     * @param os
     */
    public static void objectToStream(Object object, OutputStream os) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(os);
            oos.writeObject(object);
        } catch (IOException e) {
            throw new AppException(e);
        } finally {
            IOUtils.closeQuietly(oos);
        }
    }
}
