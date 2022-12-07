C:
cd \
cd CircuitMacros
cd dpic
m4 liblog.m4 C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc4/mtgs3/Output10.m4 | dpic -v > C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc4/mtgs3/Output10.svg
cd batik
java -Djava.awt.headless=true -jar batik-rasterizer.jar -m image/png -d C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc4/mtgs3/Output10.png C:/eclipse/runtime-EclipseApplication/wodeledulc/src-gen/html/diagrams/lc4/mtgs3/Output10.svg 2>&1
exit
