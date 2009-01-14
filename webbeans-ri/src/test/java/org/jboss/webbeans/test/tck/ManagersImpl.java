package org.jboss.webbeans.test.tck;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.webbeans.manager.Manager;

import org.jboss.webbeans.CurrentManager;
import org.jboss.webbeans.tck.api.Managers;
import org.jboss.webbeans.test.mock.MockBootstrap;

public class ManagersImpl implements Managers
{

   public Manager createManager()
   {
      new MockBootstrap();
      return CurrentManager.rootManager();
   }

   public void setEnabledDeploymentTypes(List<Class<? extends Annotation>> enabledDeploymentTypes)
   {
      CurrentManager.rootManager().setEnabledDeploymentTypes(enabledDeploymentTypes);
   }

   public List<Class<? extends Annotation>> getEnabledDeploymentTypes()
   {
      // TODO Auto-generated method stub
      return null;
   }
   
}
