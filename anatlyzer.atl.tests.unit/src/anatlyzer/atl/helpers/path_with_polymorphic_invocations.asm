<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="polymorphicpath"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchmodel():V"/>
		<constant value="__exec__"/>
		<constant value="model"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applymodel(NTransientLink;):V"/>
		<constant value="aHelper"/>
		<constant value="MABCD!A;"/>
		<constant value="0"/>
		<constant value="J.+(J):J"/>
		<constant value="6:63-6:67"/>
		<constant value="6:63-6:72"/>
		<constant value="6:75-6:80"/>
		<constant value="6:63-6:80"/>
		<constant value="param"/>
		<constant value="MABCD!B;"/>
		<constant value="propOfB"/>
		<constant value="7:63-7:67"/>
		<constant value="7:63-7:75"/>
		<constant value="7:78-7:83"/>
		<constant value="7:63-7:83"/>
		<constant value="__matchmodel"/>
		<constant value="Model"/>
		<constant value="ABCD"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="src"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="tgt"/>
		<constant value="WXYZ"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="11:10-17:3"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="elements"/>
		<constant value="4"/>
		<constant value="x"/>
		<constant value="J.aHelper(J):J"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="J.first():J"/>
		<constant value="16:11-16:14"/>
		<constant value="16:11-16:23"/>
		<constant value="16:37-16:38"/>
		<constant value="16:47-16:50"/>
		<constant value="16:37-16:51"/>
		<constant value="16:11-16:52"/>
		<constant value="16:11-16:61"/>
		<constant value="16:3-16:61"/>
		<constant value="a"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="46"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="47"/>
			<get arg="38"/>
			<load arg="19"/>
			<call arg="48"/>
		</code>
		<linenumbertable>
			<lne id="49" begin="0" end="0"/>
			<lne id="50" begin="0" end="1"/>
			<lne id="51" begin="2" end="2"/>
			<lne id="52" begin="0" end="3"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="3"/>
			<lve slot="1" name="53" begin="0" end="3"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="54"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="47"/>
			<get arg="55"/>
			<load arg="19"/>
			<call arg="48"/>
		</code>
		<linenumbertable>
			<lne id="56" begin="0" end="0"/>
			<lne id="57" begin="0" end="1"/>
			<lne id="58" begin="2" end="2"/>
			<lne id="59" begin="0" end="3"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="3"/>
			<lve slot="1" name="53" begin="0" end="3"/>
		</localvariabletable>
	</operation>
	<operation name="60">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="61"/>
			<push arg="62"/>
			<findme/>
			<push arg="63"/>
			<call arg="64"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="65"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="66"/>
			<dup/>
			<push arg="67"/>
			<load arg="19"/>
			<pcall arg="68"/>
			<dup/>
			<push arg="69"/>
			<push arg="61"/>
			<push arg="70"/>
			<new/>
			<pcall arg="71"/>
			<pusht/>
			<pcall arg="72"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="73" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="67" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="74">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="75"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="67"/>
			<call arg="76"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="69"/>
			<call arg="77"/>
			<store arg="78"/>
			<load arg="78"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="29"/>
			<get arg="79"/>
			<iterate/>
			<store arg="80"/>
			<load arg="80"/>
			<push arg="81"/>
			<call arg="82"/>
			<call arg="83"/>
			<enditerate/>
			<call arg="84"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="85" begin="14" end="14"/>
			<lne id="86" begin="14" end="15"/>
			<lne id="87" begin="18" end="18"/>
			<lne id="88" begin="19" end="19"/>
			<lne id="89" begin="18" end="20"/>
			<lne id="90" begin="11" end="22"/>
			<lne id="91" begin="11" end="23"/>
			<lne id="92" begin="9" end="25"/>
			<lne id="73" begin="8" end="26"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="93" begin="17" end="21"/>
			<lve slot="3" name="69" begin="7" end="26"/>
			<lve slot="2" name="67" begin="3" end="26"/>
			<lve slot="0" name="17" begin="0" end="26"/>
			<lve slot="1" name="94" begin="0" end="26"/>
		</localvariabletable>
	</operation>
</asm>
