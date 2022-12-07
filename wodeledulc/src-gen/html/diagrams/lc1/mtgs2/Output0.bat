C:
cd \
cd CircuitMacros
cd dpic
m4 liblog.m4 C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc1/mtgs2/Output0.m4 | dpic -v > C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc1/mtgs2/Output0.svg
cd batik
java -Djava.awt.headless=true -jar batik-rasterizer.jar -m image/png -d C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc1/mtgs2/Output0.png C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc1/mtgs2/Output0.svg 2>&1
exit
