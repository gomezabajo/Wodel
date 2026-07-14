<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="XML2DSL"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="dslElementsById"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="Map"/>
		<constant value="1"/>
		<constant value="Element"/>
		<constant value="XML"/>
		<constant value="J.allInstances():J"/>
		<constant value="2"/>
		<constant value="name"/>
		<constant value="concept"/>
		<constant value="J.=(J):J"/>
		<constant value="relationship"/>
		<constant value="J.or(J):J"/>
		<constant value="enumeration"/>
		<constant value="id"/>
		<constant value="J.hasAttr(J):J"/>
		<constant value="J.and(J):J"/>
		<constant value="48"/>
		<constant value="54"/>
		<constant value="J.getAttrVal(J):J"/>
		<constant value="J.including(JJ):J"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="20:76-20:82"/>
		<constant value="20:5-20:16"/>
		<constant value="20:5-20:31"/>
		<constant value="21:14-21:15"/>
		<constant value="21:14-21:20"/>
		<constant value="21:21-21:30"/>
		<constant value="21:14-21:30"/>
		<constant value="21:34-21:35"/>
		<constant value="21:34-21:40"/>
		<constant value="21:41-21:55"/>
		<constant value="21:34-21:55"/>
		<constant value="21:14-21:55"/>
		<constant value="21:59-21:60"/>
		<constant value="21:59-21:65"/>
		<constant value="21:67-21:80"/>
		<constant value="21:59-21:80"/>
		<constant value="21:14-21:80"/>
		<constant value="21:86-21:87"/>
		<constant value="21:96-21:100"/>
		<constant value="21:86-21:101"/>
		<constant value="21:13-21:101"/>
		<constant value="24:14-24:17"/>
		<constant value="22:14-22:17"/>
		<constant value="22:30-22:31"/>
		<constant value="22:43-22:47"/>
		<constant value="22:30-22:48"/>
		<constant value="22:50-22:51"/>
		<constant value="22:14-22:52"/>
		<constant value="21:9-25:14"/>
		<constant value="20:5-26:6"/>
		<constant value="e"/>
		<constant value="acc"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="__matcher__"/>
		<constant value="__exec__"/>
		<constant value="getAttrVal"/>
		<constant value="MXML!Element;"/>
		<constant value="0"/>
		<constant value="children"/>
		<constant value="Attribute"/>
		<constant value="J.oclIsTypeOf(J):J"/>
		<constant value="B.not():B"/>
		<constant value="21"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="J.first():J"/>
		<constant value="32:5-32:9"/>
		<constant value="32:5-32:18"/>
		<constant value="32:31-32:32"/>
		<constant value="32:45-32:58"/>
		<constant value="32:31-32:59"/>
		<constant value="32:64-32:65"/>
		<constant value="32:64-32:70"/>
		<constant value="32:73-32:77"/>
		<constant value="32:64-32:77"/>
		<constant value="32:31-32:77"/>
		<constant value="32:5-32:78"/>
		<constant value="32:5-32:87"/>
		<constant value="32:5-32:93"/>
		<constant value="c"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<field name="5" type="4"/>
	<operation name="6">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="8"/>
			<push arg="9"/>
			<new/>
			<dup/>
			<push arg="10"/>
			<pcall arg="11"/>
			<dup/>
			<push arg="12"/>
			<push arg="9"/>
			<new/>
			<dup/>
			<push arg="13"/>
			<pcall arg="11"/>
			<pcall arg="14"/>
			<set arg="3"/>
			<getasm/>
			<push arg="15"/>
			<push arg="9"/>
			<new/>
			<store arg="16"/>
			<push arg="17"/>
			<push arg="18"/>
			<findme/>
			<call arg="19"/>
			<iterate/>
			<store arg="20"/>
			<load arg="20"/>
			<get arg="21"/>
			<push arg="22"/>
			<call arg="23"/>
			<load arg="20"/>
			<get arg="21"/>
			<push arg="24"/>
			<call arg="23"/>
			<call arg="25"/>
			<load arg="20"/>
			<get arg="21"/>
			<push arg="26"/>
			<call arg="23"/>
			<call arg="25"/>
			<load arg="20"/>
			<push arg="27"/>
			<call arg="28"/>
			<call arg="29"/>
			<if arg="30"/>
			<load arg="16"/>
			<goto arg="31"/>
			<load arg="16"/>
			<load arg="20"/>
			<push arg="27"/>
			<call arg="32"/>
			<load arg="20"/>
			<call arg="33"/>
			<store arg="16"/>
			<enditerate/>
			<load arg="16"/>
			<set arg="5"/>
			<getasm/>
			<push arg="34"/>
			<push arg="9"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="35"/>
			<getasm/>
			<pcall arg="36"/>
		</code>
		<linenumbertable>
			<lne id="37" begin="17" end="19"/>
			<lne id="38" begin="21" end="23"/>
			<lne id="39" begin="21" end="24"/>
			<lne id="40" begin="27" end="27"/>
			<lne id="41" begin="27" end="28"/>
			<lne id="42" begin="29" end="29"/>
			<lne id="43" begin="27" end="30"/>
			<lne id="44" begin="31" end="31"/>
			<lne id="45" begin="31" end="32"/>
			<lne id="46" begin="33" end="33"/>
			<lne id="47" begin="31" end="34"/>
			<lne id="48" begin="27" end="35"/>
			<lne id="49" begin="36" end="36"/>
			<lne id="50" begin="36" end="37"/>
			<lne id="51" begin="38" end="38"/>
			<lne id="52" begin="36" end="39"/>
			<lne id="53" begin="27" end="40"/>
			<lne id="54" begin="41" end="41"/>
			<lne id="55" begin="42" end="42"/>
			<lne id="56" begin="41" end="43"/>
			<lne id="57" begin="27" end="44"/>
			<lne id="58" begin="46" end="46"/>
			<lne id="59" begin="48" end="48"/>
			<lne id="60" begin="49" end="49"/>
			<lne id="61" begin="50" end="50"/>
			<lne id="62" begin="49" end="51"/>
			<lne id="63" begin="52" end="52"/>
			<lne id="64" begin="48" end="53"/>
			<lne id="65" begin="27" end="53"/>
			<lne id="66" begin="17" end="56"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="67" begin="26" end="54"/>
			<lve slot="1" name="68" begin="20" end="56"/>
			<lve slot="0" name="69" begin="0" end="66"/>
		</localvariabletable>
	</operation>
	<operation name="70">
		<context type="7"/>
		<parameters>
			<parameter name="16" type="4"/>
		</parameters>
		<code>
			<load arg="16"/>
			<getasm/>
			<get arg="3"/>
			<call arg="71"/>
			<if arg="72"/>
			<getasm/>
			<get arg="1"/>
			<load arg="16"/>
			<call arg="73"/>
			<dup/>
			<call arg="74"/>
			<if arg="75"/>
			<load arg="16"/>
			<call arg="76"/>
			<goto arg="77"/>
			<pop/>
			<load arg="16"/>
			<goto arg="78"/>
			<push arg="79"/>
			<push arg="9"/>
			<new/>
			<load arg="16"/>
			<iterate/>
			<store arg="20"/>
			<getasm/>
			<load arg="20"/>
			<call arg="80"/>
			<call arg="81"/>
			<enditerate/>
			<call arg="82"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="67" begin="23" end="27"/>
			<lve slot="0" name="69" begin="0" end="29"/>
			<lve slot="1" name="83" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="84">
		<context type="7"/>
		<parameters>
			<parameter name="16" type="4"/>
			<parameter name="20" type="85"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="16"/>
			<call arg="73"/>
			<load arg="16"/>
			<load arg="20"/>
			<call arg="86"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="69" begin="0" end="6"/>
			<lve slot="1" name="83" begin="0" end="6"/>
			<lve slot="2" name="21" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="87">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="69" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="88">
		<context type="7"/>
		<parameters>
		</parameters>
		<code>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="69" begin="0" end="-1"/>
		</localvariabletable>
	</operation>
	<operation name="89">
		<context type="90"/>
		<parameters>
			<parameter name="16" type="4"/>
		</parameters>
		<code>
			<push arg="79"/>
			<push arg="9"/>
			<new/>
			<load arg="91"/>
			<get arg="92"/>
			<iterate/>
			<store arg="20"/>
			<load arg="20"/>
			<push arg="93"/>
			<push arg="18"/>
			<findme/>
			<call arg="94"/>
			<load arg="20"/>
			<get arg="21"/>
			<load arg="16"/>
			<call arg="23"/>
			<call arg="29"/>
			<call arg="95"/>
			<if arg="96"/>
			<load arg="20"/>
			<call arg="97"/>
			<enditerate/>
			<call arg="98"/>
			<get arg="83"/>
		</code>
		<linenumbertable>
			<lne id="99" begin="3" end="3"/>
			<lne id="100" begin="3" end="4"/>
			<lne id="101" begin="7" end="7"/>
			<lne id="102" begin="8" end="10"/>
			<lne id="103" begin="7" end="11"/>
			<lne id="104" begin="12" end="12"/>
			<lne id="105" begin="12" end="13"/>
			<lne id="106" begin="14" end="14"/>
			<lne id="107" begin="12" end="15"/>
			<lne id="108" begin="7" end="16"/>
			<lne id="109" begin="0" end="21"/>
			<lne id="110" begin="0" end="22"/>
			<lne id="111" begin="0" end="23"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="112" begin="6" end="20"/>
			<lve slot="0" name="69" begin="0" end="23"/>
			<lve slot="1" name="21" begin="0" end="23"/>
		</localvariabletable>
	</operation>
</asm>
