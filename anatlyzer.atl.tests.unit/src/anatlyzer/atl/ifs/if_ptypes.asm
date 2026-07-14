<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="ifptypes"/>
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
		<constant value="someComputation"/>
		<constant value="MABCD!Model;"/>
		<constant value="0"/>
		<constant value="myModel"/>
		<constant value="J.=(J):J"/>
		<constant value="7"/>
		<constant value="10"/>
		<constant value="23"/>
		<constant value="32"/>
		<constant value="J./(J):J"/>
		<constant value="7:5-7:9"/>
		<constant value="7:5-7:14"/>
		<constant value="7:17-7:26"/>
		<constant value="7:5-7:26"/>
		<constant value="10:3-10:4"/>
		<constant value="8:3-8:5"/>
		<constant value="8:8-8:10"/>
		<constant value="8:3-8:10"/>
		<constant value="7:2-11:7"/>
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
		<constant value="15:10-18:3"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="test"/>
		<constant value="J.someComputation():J"/>
		<constant value="J.floor():J"/>
		<constant value="J.toString():J"/>
		<constant value="J.+(J):J"/>
		<constant value="17:14-17:20"/>
		<constant value="17:23-17:26"/>
		<constant value="17:23-17:44"/>
		<constant value="17:23-17:52"/>
		<constant value="17:23-17:63"/>
		<constant value="17:14-17:63"/>
		<constant value="17:6-17:63"/>
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
		</parameters>
		<code>
			<load arg="47"/>
			<get arg="38"/>
			<push arg="48"/>
			<call arg="49"/>
			<if arg="50"/>
			<pushi arg="47"/>
			<goto arg="51"/>
			<pushi arg="52"/>
			<pushi arg="53"/>
			<call arg="54"/>
		</code>
		<linenumbertable>
			<lne id="55" begin="0" end="0"/>
			<lne id="56" begin="0" end="1"/>
			<lne id="57" begin="2" end="2"/>
			<lne id="58" begin="0" end="3"/>
			<lne id="59" begin="5" end="5"/>
			<lne id="60" begin="7" end="7"/>
			<lne id="61" begin="8" end="8"/>
			<lne id="62" begin="7" end="9"/>
			<lne id="63" begin="0" end="9"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="64">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="65"/>
			<push arg="66"/>
			<findme/>
			<push arg="67"/>
			<call arg="68"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="69"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="70"/>
			<dup/>
			<push arg="71"/>
			<load arg="19"/>
			<pcall arg="72"/>
			<dup/>
			<push arg="73"/>
			<push arg="65"/>
			<push arg="74"/>
			<new/>
			<pcall arg="75"/>
			<pusht/>
			<pcall arg="76"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="77" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="71" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="78">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="79"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="71"/>
			<call arg="80"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="73"/>
			<call arg="81"/>
			<store arg="82"/>
			<load arg="82"/>
			<dup/>
			<getasm/>
			<push arg="83"/>
			<load arg="29"/>
			<call arg="84"/>
			<call arg="85"/>
			<call arg="86"/>
			<call arg="87"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="88" begin="11" end="11"/>
			<lne id="89" begin="12" end="12"/>
			<lne id="90" begin="12" end="13"/>
			<lne id="91" begin="12" end="14"/>
			<lne id="92" begin="12" end="15"/>
			<lne id="93" begin="11" end="16"/>
			<lne id="94" begin="9" end="18"/>
			<lne id="77" begin="8" end="19"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="73" begin="7" end="19"/>
			<lve slot="2" name="71" begin="3" end="19"/>
			<lve slot="0" name="17" begin="0" end="19"/>
			<lve slot="1" name="95" begin="0" end="19"/>
		</localvariabletable>
	</operation>
</asm>
