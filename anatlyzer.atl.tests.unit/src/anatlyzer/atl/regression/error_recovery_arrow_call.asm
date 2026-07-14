<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="error recovery invalid arrow call"/>
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
		<constant value="A.__matcha2other():V"/>
		<constant value="__exec__"/>
		<constant value="model"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applymodel(NTransientLink;):V"/>
		<constant value="a2other"/>
		<constant value="A.__applya2other(NTransientLink;):V"/>
		<constant value="getAllInstances"/>
		<constant value="ABCD"/>
		<constant value="J.allInstances():J"/>
		<constant value="J.asSet():J"/>
		<constant value="4:60-4:66"/>
		<constant value="4:60-4:81"/>
		<constant value="4:60-4:90"/>
		<constant value="str"/>
		<constant value="__matchmodel"/>
		<constant value="Model"/>
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
		<constant value="9:10-12:3"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="tests that even with an invalid &quot;-&gt; call&quot; the solver is going to work"/>
		<constant value="dummy"/>
		<constant value="J.getAllInstances(J):J"/>
		<constant value="elements"/>
		<constant value="10:14-10:85"/>
		<constant value="10:6-10:85"/>
		<constant value="11:15-11:25"/>
		<constant value="11:43-11:50"/>
		<constant value="11:15-11:51"/>
		<constant value="11:3-11:51"/>
		<constant value="link"/>
		<constant value="__matcha2other"/>
		<constant value="a"/>
		<constant value="Other"/>
		<constant value="19:3-21:4"/>
		<constant value="__applya2other"/>
		<constant value="aname"/>
		<constant value="20:12-20:19"/>
		<constant value="20:4-20:19"/>
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
			<getasm/>
			<pcall arg="41"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="3"/>
		</localvariabletable>
	</operation>
	<operation name="42">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="45"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="46"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="47"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="0" name="17" begin="0" end="19"/>
		</localvariabletable>
	</operation>
	<operation name="48">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<push arg="6"/>
			<push arg="49"/>
			<findme/>
			<call arg="50"/>
			<call arg="51"/>
		</code>
		<linenumbertable>
			<lne id="52" begin="0" end="2"/>
			<lne id="53" begin="0" end="3"/>
			<lne id="54" begin="0" end="4"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="4"/>
			<lve slot="1" name="55" begin="0" end="4"/>
		</localvariabletable>
	</operation>
	<operation name="56">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="57"/>
			<push arg="49"/>
			<findme/>
			<push arg="58"/>
			<call arg="59"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="60"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="43"/>
			<pcall arg="61"/>
			<dup/>
			<push arg="62"/>
			<load arg="19"/>
			<pcall arg="63"/>
			<dup/>
			<push arg="64"/>
			<push arg="57"/>
			<push arg="65"/>
			<new/>
			<pcall arg="66"/>
			<pusht/>
			<pcall arg="67"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="68" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="62" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="69">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="70"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="62"/>
			<call arg="71"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="64"/>
			<call arg="72"/>
			<store arg="73"/>
			<load arg="73"/>
			<dup/>
			<getasm/>
			<push arg="74"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<getasm/>
			<push arg="75"/>
			<call arg="76"/>
			<call arg="30"/>
			<set arg="77"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="78" begin="11" end="11"/>
			<lne id="79" begin="9" end="13"/>
			<lne id="80" begin="16" end="16"/>
			<lne id="81" begin="17" end="17"/>
			<lne id="82" begin="16" end="18"/>
			<lne id="83" begin="14" end="20"/>
			<lne id="68" begin="8" end="21"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="64" begin="7" end="21"/>
			<lve slot="2" name="62" begin="3" end="21"/>
			<lve slot="0" name="17" begin="0" end="21"/>
			<lve slot="1" name="84" begin="0" end="21"/>
		</localvariabletable>
	</operation>
	<operation name="85">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="6"/>
			<push arg="49"/>
			<findme/>
			<push arg="58"/>
			<call arg="59"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="60"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="46"/>
			<pcall arg="61"/>
			<dup/>
			<push arg="86"/>
			<load arg="19"/>
			<pcall arg="63"/>
			<dup/>
			<push arg="64"/>
			<push arg="87"/>
			<push arg="65"/>
			<new/>
			<pcall arg="66"/>
			<pusht/>
			<pcall arg="67"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="88" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="86" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="89">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="70"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="86"/>
			<call arg="71"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="64"/>
			<call arg="72"/>
			<store arg="73"/>
			<load arg="73"/>
			<dup/>
			<getasm/>
			<push arg="90"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="91" begin="11" end="11"/>
			<lne id="92" begin="9" end="13"/>
			<lne id="88" begin="8" end="14"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="64" begin="7" end="14"/>
			<lve slot="2" name="86" begin="3" end="14"/>
			<lve slot="0" name="17" begin="0" end="14"/>
			<lve slot="1" name="84" begin="0" end="14"/>
		</localvariabletable>
	</operation>
</asm>
