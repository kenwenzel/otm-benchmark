#!/bin/bash

JAVA=/opt/java-8-oracle/bin/java
OUTPUT=benchmark.log
LOGFILE=logback.xml
WARMUPS=10
ROUNDS=100

> ${OUTPUT}
echo "Running benchmark..."

#AliBaba Benchmark
echo "Running AliBaba..."
cd alibaba-benchmark/target
echo "---------------------------------------" >> ../../${OUTPUT}
echo "|               AliBaba               |" >> ../../${OUTPUT}
echo "---------------------------------------" >> ../../${OUTPUT}

echo "Create..."
echo "*** CREATE ***" >> ../../${OUTPUT}
${JAVA} -jar -Dlogback.configurationFile=${LOGFILE} alibaba-benchmark.jar -w $WARMUPS -r $ROUNDS create >> ../../${OUTPUT}
echo "Retrieve..."
echo "*** RETRIEVE ***" >> ../../${OUTPUT}
${JAVA} -jar -Dlogback.configurationFile=${LOGFILE} alibaba-benchmark.jar -w $WARMUPS -r $ROUNDS retrieve >> ../../${OUTPUT}
cd ../..

#Empire Benchmark
echo "Running Empire..."
cd empire-benchmark/target
echo "---------------------------------------" >> ../../${OUTPUT}
echo "|               Empire                |" >> ../../${OUTPUT}
echo "---------------------------------------" >> ../../${OUTPUT}

echo "Create..."
echo "*** CREATE ***" >> ../../${OUTPUT}
${JAVA} -jar -Dlogback.configurationFile=${LOGFILE} empire-benchmark.jar -w $WARMUPS -r $ROUNDS create >> ../../${OUTPUT}
echo "Retrieve..."
echo "*** RETRIEVE ***" >> ../../${OUTPUT}
${JAVA} -jar -Dlogback.configurationFile=${LOGFILE} empire-benchmark.jar -w $WARMUPS -r $ROUNDS retrieve >> ../../${OUTPUT}
cd ../..

# JOPA Benchmark
echo "Running JOPA..."
cd jopa-benchmark/target
echo "---------------------------------------" >> ../../${OUTPUT}
echo "|               JOPA                  |" >> ../../${OUTPUT}
echo "---------------------------------------" >> ../../${OUTPUT}

echo "Create..."
echo "*** CREATE ***" >> ../../${OUTPUT}
${JAVA} -jar -Dlogback.configurationFile=${LOGFILE} jopa-benchmark.jar -w $WARMUPS -r $ROUNDS create >> ../../${OUTPUT}
echo "Retrieve..."
echo "*** RETRIEVE ***" >> ../../${OUTPUT}
${JAVA} -jar -Dlogback.configurationFile=${LOGFILE} jopa-benchmark.jar -w $WARMUPS -r $ROUNDS retrieve >> ../../${OUTPUT}
cd ../..

# Komma Benchmark
echo "Running KOMMA..."
cd komma-benchmark/target
echo "---------------------------------------" >> ../../${OUTPUT}
echo "|               KOMMA                 |" >> ../../${OUTPUT}
echo "---------------------------------------" >> ../../${OUTPUT}

echo "Create..."
echo "*** CREATE ***" >> ../../${OUTPUT}
${JAVA} -jar -Dlogback.configurationFile=${LOGFILE} komma-benchmark.jar -w $WARMUPS -r $ROUNDS create >> ../../${OUTPUT}
echo "Retrieve..."
echo "*** RETRIEVE ***" >> ../../${OUTPUT}
${JAVA} -jar -Dlogback.configurationFile=${LOGFILE} komma-benchmark.jar -w $WARMUPS -r $ROUNDS retrieve >> ../../${OUTPUT}
cd ../..

# RDFBeans Benchmark
echo "Running RDFBeans..."
cd rdfbeans-benchmark/target
echo "---------------------------------------" >> ../../${OUTPUT}
echo "|               RDFBeans              |" >> ../../${OUTPUT}
echo "---------------------------------------" >> ../../${OUTPUT}

echo "Create..."
echo "*** CREATE ***" >> ../../${OUTPUT}
${JAVA} -jar -Dlogback.configurationFile=${LOGFILE} rdfbeans-benchmark.jar -w $WARMUPS -r $ROUNDS create >> ../../${OUTPUT}
echo "Retrieve..."
echo "*** RETRIEVE ***" >> ../../${OUTPUT}
${JAVA} -jar -Dlogback.configurationFile=${LOGFILE} rdfbeans-benchmark.jar -w $WARMUPS -r $ROUNDS retrieve >> ../../${OUTPUT}
cd ../..

echo "Benchmark finished."
